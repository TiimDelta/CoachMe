import {HttpClient, json} from 'aurelia-fetch-client'
import environment from '../environment';
import {AuthService} from 'aurelia-auth';
import {inject} from 'aurelia-framework';

@inject(HttpClient, AuthService)
export class Home{

  constructor(http: HttpClient, auth: AuthService){
    this.auth = auth;
    this.message = "Just checking... ";
    if (auth.isAuthenticated()) {
      auth.getMe().then(
        user => this.message += user['email'] + " on sisse logitud!"
      )
    } else {
      this.message += "logimata!"
    }
    this.appName = "coachMe";
    this.count = 0;
    this.http = http;
  };

  authenticate(provider){
    return this.auth.authenticate(provider)
      .then((response)=>{
        console.log("auth response " + response);
      });
  }

  trainingData ={ "id" : "",
    "trainer" : "",
    "location":"",
    "workout":"",
    "mail":""
  }
  userData ={     "username" : "",
    "firstName" : "",
    "lastname":"",
    "password":"",
    "mail":"",
    "userType":"false"
  }
  commentData ={
    "text":"",
    "training": {"id":""}
  }
  trainingList =[]
  searchInput="";



  activate(){
    if (this.searchInput != "") {
      this.http.fetch(environment.url + 'trainings/'+this.searchInput)
        .then(response => response.json())
        .then(trainings => this.trainingList = trainings);
      console.log("OOOO keegi otsib")
    }
    else {
      this.http.fetch(environment.url + 'trainings')
        .then(response => response.json())
        .then(trainings => this.trainingList = trainings);

      console.log("Get Method executed!")

    }

  }
  addTraining(){
    this.activate();

    this.http.fetch(environment.url + 'trainings/add', {
      'method': "POST",
      'body': json(this.trainingData)
    })
      .then(response => response.json())
      .then(data => {
        console.log("Server saatis " + data.trainer);
      });

    console.log("Method executed!");
  }
  addUser(){
    this.activate();

    this.http.fetch(environment.url + 'users/add', {
      'method': "POST",
      'body': json(this.userData)
    })
      .then(response => response.json())
      .then(data => {
        console.log("Server saatis " + data.username);
      });

    console.log("User registered");
  }
  uploadImage(){
    this.profileImage.click();
  }
  profileImageChange(){
    if (this.profileImage.files && this.profileImage.files[0]){
      this.updateImage.setAttribute('src', window.URL.createObjectURL(this.profileImage.files[0]));
    }
  }
  showPopup(popupId){
    document.getElementById(popupId.toString()).style.display='block';

  }
  closePopup(popupId){
    document.getElementById(popupId.toString()).style.display='none';
  }
  addComment(training_id){
    this.activate();

    this.commentData.training.id = training_id;
    let client = new HttpClient();
    client.fetch(environment.url + 'comments/add', {
      'method': "POST",
      'body': json(this.commentData)
    })
      .then(response => response.json())
      .then(data => {
        console.log("Server saatis " + data.text);
      });

    console.log("Method executed!");
  }
}
