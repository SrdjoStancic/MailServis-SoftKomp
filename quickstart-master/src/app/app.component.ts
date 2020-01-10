import { Component } from '@angular/core';
import {Account} from './account.model';


@Component({
  selector: 'my-app',
  templateUrl: `app/app.component.html`
})
export class AppComponent  {

  private _accounts:Array<Account>= [
    new Account("krmenadla@gmail.com","1234","exchange rate","day")
  ]
  private createAcc(emailEl:any , passwordEl:any , topicEl:any , notificationEl:any)
  {
    this._accounts.push(new Account(
                                      emailEl.value,
                                      passwordEl.value,
                                      topicEl.value,
                                      notificationEl.value
                                    )
                        )
    emailEl.value=""
    passwordEl.value=""
    topicEl.value=""
    notificationEl.value=""
  }
  private currentUser:User= {username: "Test", email: "test@test.com"}

  private hideEmail:boolean= false

  private disabledInput:boolean= true

  private isDisabled():boolean {
    return this.disabledInput
  }
  private isBlueBg:boolean = true
  private bgColor:string = 'red'


  private changeMail(newMail:string, name:string)
  {
    this.currentUser.email=newMail
    this.currentUser.username=name
  }
/*
  private users:Array<User> = [
    { username:"User1" , email:"user1@test.com"},
    { username:"User2" , email:"user2@test.com"},
    { username:"User3" , email:"user3@test.com"},
    { username:"User4" , email:"user4@test.com"}
  ]

  private addUser(nextMail:string, name:string)
  {
    this.users= {username:"User133" , email:"user12@test.com"}
  }
*/
}

interface User {
  username:string,
  email:string
}
