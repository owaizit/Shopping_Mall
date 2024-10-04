import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StoreService } from './store.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'store-module';
  storeDetails: any[] = [];
  storeToUpdate: any = {
    storeId: null,
    name: '',
    category: '',
    contactInfo: '',
    location: '',
    operatingHours: ''
  };

  constructor(private storeService: StoreService) {
    this.getStoreDetails();
  }

  register(registerForm: NgForm) {
    this.storeService.registerStore(registerForm.value).subscribe(
      (resp: any) => {
        console.log(resp);
        registerForm.reset();
        this.getStoreDetails();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  getStoreDetails() {
    this.storeService.getStores().subscribe(
      (resp: any) => {
        console.log(resp);
        this.storeDetails = resp;
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  deleteStore(store: any) {
    this.storeService.deleteStore(store.storeId).subscribe(
      (resp: any) => {
        console.log(resp);
        this.getStoreDetails();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  edit(store: any) {
    this.storeToUpdate = { ...store };
  }

  updateStore() {
    this.storeService.updateStore(this.storeToUpdate).subscribe(
      (resp: any) => {
        console.log(resp);
        this.getStoreDetails();
      },
      (err: any) => {
        console.log(err);
      }
    );
  }
}
