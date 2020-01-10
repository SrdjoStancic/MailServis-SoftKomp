export class Account {

  public email:string

  public password:string

  public topic:string

  public notification:string

  public constructor(email:string , password:string , topic:string, notification:string){
    this.email = email
    this.password = password
    this.topic = topic
    this.notification = notification
  }
}
