import express, { Request, Response } from 'express'
import { loginUser, registerUser }  from '../controllers/userController';
import { authUser } from '../middlewares/authUser';
import bodyParser from 'body-parser';

const router = express.Router();
var urlencodedParser = bodyParser.urlencoded({ extended: false })

// Use Token and Get User Details: GET "api/users/getuser" Login Required
router.get('/', (req: Request, res: Response) => {
    res.render('home', { data: {} });
})

// Authenticate User and Genrate Token: POST "api/users/login"
router.get('/login', (req: Request, res: Response) => {
    res.render('login', { data: {} });
})
router.post('/login', urlencodedParser, loginUser)

// Authenticate User and Genrate Token: POST "api/users/register"
router.get('/register', (req: Request, res: Response) => {
    res.render('register', { data: {} });
})
router.post('/register', urlencodedParser, registerUser)

export { router }