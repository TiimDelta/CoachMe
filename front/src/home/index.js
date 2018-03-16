import {HttpClient, json} from 'aurelia-fetch-client'

export class Home{

  trainingData ={ "trainer" : "",
                  "location":"",
                  "workout":"",
                  "mail":""
  }
  trainingList =[]

  activate(){
    let client = new HttpClient();
    client.fetch('http://localhost:8080/trainings')
      .then(response => response.json())
      .then(trainings => this.trainingList = trainings);

    console.log("Get Method executed!")
  }
	addTraining(){
    this.activate();
		let client = new HttpClient();



		client.fetch('http://localhost:8080/trainings/add', {
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
