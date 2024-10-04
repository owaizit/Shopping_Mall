import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StoreService {
  private API = "http://localhost:8080/storeservice";

  constructor(private http: HttpClient) { }

  public registerStore(storeData: any) {
    return this.http.post(this.API, storeData);
  }

  public getStores() {
    return this.http.get(this.API);
  }

  public deleteStore(storeId: any) {
    return this.http.delete(`${this.API}/${storeId}`);
  }

  public updateStore(store: any) {
    return this.http.put(`${this.API}/${store.storeId}`, store);
  }
}

