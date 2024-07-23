import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MessageService } from '../services/message.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [MatCardModule,MatInputModule,MatFormFieldModule, MatButtonModule,HttpClientModule],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css',
  providers: [MessageService]
})
export class ChatComponent {
  constructor(private msgService: MessageService){}
  sendMsg(key:HTMLInputElement ,msg: HTMLInputElement){
    const data = {
      key: key.value,
      message: msg.value
    };
    this.msgService.sendMessage(data).subscribe(
      response =>{
        console.log('Response',response);
        msg.value = '';
      },
      error => {
        console.error('Error:',error);
        msg.value = ''; 
      }
    );
  }
}
