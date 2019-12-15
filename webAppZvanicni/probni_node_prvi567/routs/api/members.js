

const express= require('express');
const router = express.Router();
const members= require('../../Members');



var tempMember= {
    
    email: 'some1',
    password: '1234'
   
}

//Create Member
router.post('/', (req,res)=>{
    console.log(req.body);
    const newMember = {

       
        email: req.body.email,
        password: req.body.password
    }
    //var brojac=0;
    console.log(newMember);

    /*if(!newMember.name || !newMember.email )
    {
       return  res.status(400).json({msg: ' please include a name and email'});

    }

    members.forEach(member =>{
        if(member.name==newMember.name && member.email==newMember.email)
        {
            if(isNaN(newMember.spent))
            {
                member.spent=member.spent;
                brojac=1;
            }
            else{
                member.spent+=newMember.spent;
                brojac=1;
            }     
        }
    });
    
    tempMember={
        id: newMember.id,
        name: newMember.name,
        email: newMember.email,
        status: newMember.status,
        spent: 0
    }
    if(brojac==0)
    {
        members.push(tempMember);
    }
    
    //res.json(members);*/
    res.redirect('/index');
    //window.location.href= '/nextPage';

});

//Update Member





module.exports= router;