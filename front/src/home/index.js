import {HttpClient, json} from 'aurelia-fetch-client'

export class Home{

  trainingData ={ "trainer" : "",
                  "location":"",
                  "workout":"",
                  "mail":""}

	addTraining(){
		let client = new HttpClient();



		client.fetch('http://localhost:8080/trainings/add', {
			'method': "POST",
			'body': json(this.trainingData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("Server saatis " + data.trainer);
		});

		console.log("Method executed!")
	}
}
