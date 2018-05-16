import {HttpClient, json} from 'aurelia-fetch-client'
import environment from '../environment';
import {AuthService} from 'aurelia-auth';
import {inject} from 'aurelia-framework';

@inject(HttpClient, AuthService)
export class Home{

  constructor(http: HttpClient, auth: AuthService){
    this.auth = auth;
    if (auth.isAuthenticated()) {
      auth.getMe().then(
        user => this.message = user['email']
      )
    } else {
    }
    this.appName = "coachMe";
    this.count = 0;
    this.http = http;
  };

  authenticate(provider){
    this.activate();

    return this.auth.authenticate(provider)
      .then((response)=>{
        console.log("auth response " + response);
        location.reload(1);
      });
  }
  logout(){
    this.activate();
    this.auth.logout();
    this.http = new HttpClient();
    location.reload(1);

  }

  trainingData ={ "id" : "",
    "trainer" : "",
    "location":"",
    "workout":"",
    "mail":""
  }
  userData ={}
  commentData ={
    "text":"",
    "training": {"id":""},
    "mail":""
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

    this.trainingData.mail = this.message;
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
    this.commentData.mail = this.message;
    this.http.fetch(environment.url + 'comments/add', {
      'method': "POST",
      'body': json(this.commentData)
    })
      .then(response => response.json())
      .then(data => {
        console.log("Server saatis " + data.text);
      });
    location.reload(1);
    console.log("Method executed!");
  }
}
