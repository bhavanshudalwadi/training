import { configDotenv } from "dotenv"
configDotenv();
import { Request, Response, NextFunction } from 'express';
import jwt, { Secret, JwtPayload } from 'jsonwebtoken';

export const SECRET_KEY: Secret = process.env.JWT_SECRET || 'bhavanshudalwadi@dalwadi.com';

export interface User {
    _id: string,
    name: string,
    email: string,
    phone?: string,
    password?: string,
}

export interface CustomRequest extends Request {
    user: User | string | JwtPayload;
}

export const authUser = (req: any, res: Response, next: NextFunction) => {
    try {
        const token = req.header('Auth-Token')?.replace('Bearer ', '') || '';
        if(!token || token === ''){
            res.status(401).send({error: "Authentication token is invalid"})
        }

        const data = jwt.verify(token, SECRET_KEY);
        req.user = (data as CustomRequest).user

        next()
    } catch (error) {
        res.status(401).send({error: "Authentication token is invalid"})
    }
}