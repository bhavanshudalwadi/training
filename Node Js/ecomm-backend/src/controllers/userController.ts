import jwt from "jsonwebtoken";
import bcrypt from "bcryptjs";
import { Request, Response } from "express";
import { SECRET_KEY } from "../middlewares/authUser";
import { PrismaClient } from "@prisma/client";

const prisma = new PrismaClient();

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
      return res.render("login", {
        data: { error: "Invalid Password", invalidFields },
      });
    }
  }

  if (emptyFields.length > 0) {
    return res.render("login", {
      data: { error: "Please fill the all the fields", emptyFields },
    });
  }

  try {
    const user = await prisma.user.findUnique({
      where: {
        email,
      },
    });

    if (!user) {
      return res.render("login", { data: { error: "Enter valid user details" } });
    }

    const passComp = await bcrypt.compare(password, user.password);
    if (!passComp) {
      return res.render("login", { data: { error: "Enter valid user details" } });
    }

    const data = { user };
    const authToken = jwt.sign(data, SECRET_KEY);

    return res.render("login", { data: { message: "Login Successful", authToken } });
  } catch (error: any) {
    console.error(error.message);
    return res.render("login", { data: { error: "Internal Server Error" } });
  }
};

const registerUser = async (req: Request, res: Response) => {
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
        res.render("register", {data: {
          error: "Email is already exist",
          invalidFields,
        }});
        return;
      }
    } catch (error: any) {
      console.error(error.message);
      res.render("register", {data: { error: "Internal Server Error" }});
      return;
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
    res.render("register", {data: {
      error: "Please fill the all the fields",
      emptyFields,
    }});
    return;
  }
  if (invalidFields.length > 0) {
    if (
      invalidFields.indexOf("name") >= 0 ||
      invalidFields.indexOf("password") >= 0
    ) {
      res.render("register", {data: {
        error: "Name or Password is To Short",
        invalidFields,
      }});
      return;
    }
    if (invalidFields.indexOf("phone") >= 0) {
      res.render("register", {data: {
        error: "Please enter valid phone number",
        invalidFields,
      }});
      return;
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

    res.render("register", {data: { message: "Registration Successful", authToken }});
    return;
  } catch (error: any) {
    console.error(error.message);
    res.render("register", {data: { error: "Internal Server Error" }});
    return;
  }
};

export { loginUser, registerUser };
