import { Component, OnInit } from '@angular/core';
import { TrainingService } from '../training.service';
import { Training } from '../search/Training';

@Component({
  selector: 'app-mentorhome',
  templateUrl: './mentorhome.component.html',
  styleUrls: ['./mentorhome.component.css']
})
export class MentorhomeComponent implements OnInit {

  trainingList:Training[];

  constructor(private trainingService:TrainingService) { }

  ngOnInit() {
    this.getTrainingData();

  }

  getTrainingData() {
    this.trainingService.getTraining().subscribe(
      (data)=>{
        this.trainingList = data;
        console.log(data)
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  acceptRequest(training:Training) {
    training.status = "Accepted";
    this.trainingService.saveStatus(training).subscribe(
      (data)=>{
        window.alert("Accepted Succesfully");
        this.getTrainingData();
      },
      (error)=>{
        console.log(error);
      }
    )
  }

  declineRequest(training:Training){
    training.status = "Denied";
    this.trainingService.saveStatus(training).subscribe(
      (data)=>{
        window.alert("Rejected request");
        this.getTrainingData();
      },
      (error)=>{
        console.log(error);
      }
    )
  }

}

