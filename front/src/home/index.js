import {HttpClient, json} from 'aurelia-fetch-client'
import environment from '../environment'

export class Home{

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
  trainingList =[]
  searchInput="";



  activate(){
    let client = new HttpClient();

    if (this.searchInput != "") {
      client.fetch(environment.url + 'trainings/'+this.searchInput)
        .then(response => response.json())
        .then(trainings => this.trainingList = trainings);
        console.log("OOOO keegi otsib")
    }
    else {
      client.fetch(environment.url + 'trainings')
        .then(response => response.json())
        .then(trainings => this.trainingList = trainings);

      console.log("Get Method executed!")
    }

  }
	addTraining(){
    this.activate();
    let client = new HttpClient();

    client.fetch(environment.url + 'trainings/add', {
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
    let client = new HttpClient();

    client.fetch(environment.url + 'users/add', {
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
}
