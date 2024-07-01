import jwt from "jsonwebtoken";
import bcrypt from "bcryptjs";
import { Request, Response } from "express";
import { SECRET_KEY } from "../middlewares/authUser";
import { PrismaClient } from "@prisma/client";

const prisma = new PrismaClient();

const createUser = async (req: Request, res: Response) => {
  const { name, email, phone, password } = req.body;

  const emptyFields = [];
  const invalidFields = [];

  let regex = new RegExp(/(0|91)?[6-9][0-9]{9}/);

  if (!email) {
    emptyFields.push("email");
  } else {
    try {
      const user = await prisma.user.findFirst({
        where: {
          email,
        },
      });
      if (user) {
        invalidFields.push("email");
        return res
          .status(400)
          .json({ error: "Email is already exist", invalidFields });
      }
    } catch (error: any) {
      console.error(error.message);
      res.status(500).json({ error: "Internal Server Error" });
    }
  }
  if (!name) {
    emptyFields.push("name");
  } else {
    if (name.length < 3) {
      invalidFields.push("name");
    }
  }
  if (!phone) {
    emptyFields.push("phone");
  } else {
    if (phone.length < 10) {
      invalidFields.push("phone");
    } else if (!regex.test(phone)) {
      invalidFields.push("phone");
    }
  }
  if (!password) {
    emptyFields.push("password");
  } else {
    if (password.length < 8) {
      invalidFields.push("password");
    }
  }

  if (emptyFields.length > 0) {
    return res
      .status(400)
      .json({ error: "Please fill the all the fields", emptyFields });
  }
  if (invalidFields.length > 0) {
    if (
      invalidFields.indexOf("name") >= 0 ||
      invalidFields.indexOf("password") >= 0
    ) {
      return res
        .status(400)
        .json({ error: "Name or Password is To Short", invalidFields });
    }
    if (invalidFields.indexOf("phone") >= 0) {
      return res
        .status(400)
        .json({ error: "Please enter valid phone number", invalidFields });
    }
  }

  // Password Hasing
  const salt = await bcrypt.genSalt(10);
  const secPass = await bcrypt.hash(password, salt);

  // add doc to db
  try {
    const user = await prisma.user.create({
      data: {
        name,
        email,
        phone,
        password: secPass,
      },
    });

    const data = { user };
    const authToken = jwt.sign(data, SECRET_KEY);

    res.status(200).json({ authToken });
  } catch (error: any) {
    console.error(error.message);
    res.status(500).json({ error: "Internal Server Error" });
  }
};

const loginUser = async (req: Request, res: Response) => {
  const { email, password } = req.body;

  const emptyFields = [];
  const invalidFields = [];

  if (!email) {
    emptyFields.push("email");
  }
  if (!password) {
    emptyFields.push("password");
  } else {
    if (password.length < 8) {
      invalidFields.push("password");
      return res.status(400).json({ error: "Invalid Password", invalidFields });
    }
  }

  if (emptyFields.length > 0) {
    return res
      .status(400)
      .json({ error: "Please fill the all the fields", emptyFields });
  }

  try {
    const user = await prisma.user.findUnique({
      where: {
        email
      },
    });

    if (!user) {
      return res.status(400).json({ error: "Enter valid user details" }); //User not exist
    }

    const passComp = await bcrypt.compare(password, user.password);
    if (!passComp) {
      return res.status(400).json({ error: "Enter valid user details" }); //Password is wrong
    }

    const data = { user };
    const authToken = jwt.sign(data, SECRET_KEY);

    res.status(200).json({ authToken });
  } catch (error: any) {
    console.error(error.message);
    res.status(500).json({ error: "Internal Server Error" });
  }
};

const getUser = async (req: any, res: Response) => {
    console.log(req.user);
    try {
        if (req.user === undefined && req.user === null && req.user.id === undefined && req.user.id === null) {
            return res.status(404).json({ error: "Authentication Failed" });
        } else {
            const userId = req.user.id;
            const user = await prisma.user.findUnique({
                where: {
                    id: userId,
                },
                select: {
                    id: true,
                    name: true,
                    email: true,
                    phone: true,
                },
            });
            if (!user) {
                return res.status(404).json({ error: "No Such User Found" });
            }
            res.status(200).json(user);
        }
    } catch (error: any) {
        console.error(error.message);
        res.status(500).json({ error: "Internal Server Error" });
    }
};

export { loginUser, getUser, createUser };
