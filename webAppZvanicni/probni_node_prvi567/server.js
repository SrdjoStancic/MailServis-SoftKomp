const express = require('express');
const path = require('path');

const exphbs = require('express-handlebars');

const logger = require('./middleware/logger');
const members= require('./Members');



const app = express();



//Init middleware
//app.use(logger);


// Handlebars Middlewarea
app.engine('handlebars', exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');


//body parser midleware
app.use(express.json());
app.use(express.urlencoded({extended: false}));



//Homepage route
app.get('/', (req, res) => res.render('index',{
    title: 'Log in page',
    members

}));

app.get('/index', (req, res) => res.render('index',{
    title: 'Log in page',
    members
}));
app.get('/nextPage', (req, res) => res.render('nextPage',{
    title: 'Register user',
    token: 'KF25-J3O9-55KA',
    members
}));






// Set static folder
app.use(express.static(path.join(__dirname,'public')));


//Members API Routes

app.use('/api/members',require('./routs/api/members'));
// const korpa =require('./routs/api/korpa');
// app.use('/korpa',korpa);

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => console.log('Server pokrenut na portu '));
