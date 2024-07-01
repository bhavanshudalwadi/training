import { configDotenv } from 'dotenv'
import express, { Express } from 'express'
import path from 'path'
import cors from 'cors'
import { apiRouter } from './routes/userApiRoutes';
import { router } from './routes/userRoutes';

configDotenv();

const app: Express = express()

// app.use(express.cookieParser());
// app.use(express.session({ secret: "keyboard cat" }));
// app.use(express.bodyParser());
// app.use(express.methodOverride());

app.set('view engine', 'ejs')
app.set('views', path.join(__dirname, '/views'))
app.use(cors());
app.use(express.json());

app.use('/api/users', apiRouter);
app.use('/', router);

// app.get('/', (req: Request, res: Response) => {
//     res.render('sample', { obj: { title: "Bhavanshu", description: "Hello, Bhavanshu" } })
// })

const port = process.env.PORT || 4000
app.listen(port, () => console.log(`App is listing on port ${port}`))