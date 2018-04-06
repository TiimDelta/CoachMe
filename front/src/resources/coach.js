import {HttpClient, json} from 'aurelia-fetch-client'
import environment from '../environment'

export class coach{

  trainingData ={ "trainer" : "",
    "location":"",
    "workout":"",
    "mail":""
  }
  trainingList =[]

  activate(){
    let client = new HttpClient();
    client.fetch(environment.url + 'trainings')
      .then(response => response.json())
      .then(trainings => this.trainingList = trainings);

    console.log("Get Method executed!")
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
}
