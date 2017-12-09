import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';

import { Users } from '../users';
import { US } from '../mock-users';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {
  
    users: Users[];
  
    selectedUser: Users; 
  
    constructor(private userService: UserService) { }
  
    ngOnInit() {
      this.getUsers();
    }
  
    onSelect(user: Users): void {
      this.selectedUser = user;
    }

    getUsers(): void {
      this.userService.getUsers()
        .subscribe(users => this.users = users);
    }

    addUser(userEmail: NgModel, userName: NgModel, userPsw: NgModel, userRole: NgModel){
      const index = this.users.length + 1;
      this.userService.add({id: index, email: userEmail.value, name: userName.value, password: userPsw.value,  role: userRole.value });
      userName.reset();
      userEmail.reset();
      userRole.reset();
      userPsw.reset();
    }

    removeUser(user){
      this.userService.remove(user);
    }

}
