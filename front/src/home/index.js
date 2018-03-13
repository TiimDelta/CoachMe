import {HttpClient, json} from 'aurelia-fetch-client'

export class Home{

	addTraining(){
		let client = new HttpClient();

		let trainingData = {
      "trainer": "xxTommy",
    	"location": "Idaxx",
    	"mail": "axx",
    	"workout": "Jomm"
		}

		client.fetch('http://localhost:8080/trainings/add', {
			'method': "POST",
			'body': json(trainingData)
		})
			.then(response => response.json())
			.then(data => {
				console.log("Server saatis " + data.trainer);
		});

		console.log("Method executed!")
	}
}
