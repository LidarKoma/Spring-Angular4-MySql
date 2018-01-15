import { ICountry } from './ICountry';
import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import { error } from 'selenium-webdriver';



@Injectable()
export class CountryService {
    constructor(private _http:HttpClient) {}

    getCountries(): Observable<ICountry[]> {
        return this._http.get<ICountry[]>(
          'http://localhost:8080/api/getCountries'
        );

    }

    // getCountry(code: string): Observable<ICountry> {

    getCountry(code: string): Observable<ICountry> {
        return this._http.get<ICountry>(
         //'http://localhost/angularphp/services/getCountry.php?code=' +
         //encodeURIComponent(code)
         'http://localhost:8080/api/getCountry?code=' +
         encodeURIComponent(code)
        );

    }

    

    addState(name: string, code: string): Observable<boolean> {
        return this._http.post<boolean>(
          'http://localhost:8080/api/addState',
          //{name:name, code:code}
          new HttpParams()
          .set("name", name)
          .set("code", code)
          .toString(),
         { headers: new HttpHeaders().set("Content-Type", "application/x-www-form-urlencoded")}
        );

    }
}