import { IState } from './IState';
import { ActivatedRoute } from '@angular/router';
import { CountryService } from './country.service';
import { ICountry } from './ICountry';
import { Component, Input, OnInit } from '@angular/core';

@Component({
    selector: 'country-details',
    templateUrl: './country-details.component.html'
})
export class CountryDetailsComponent implements OnInit {
    private _code: string ="";
    public _country:ICountry;
    private _newState: string="";
    constructor(private _route: ActivatedRoute,
                private _countryService: CountryService) {}
                
    ngOnInit(): void {
        this._route.params.subscribe(
            params=> {
                this._code=params["code"];
                this.getcountry();
           }
       )
    }

    getcountry() {
        if(this._code) {
            this._countryService.getCountry(this._code)
            .subscribe(country => {this._country = country;
      },
      err => {
        console.log(err);
      }
 
    );
}
}
    addState(): void {
        var newState: IState = {name: this._newState };
        this._country.states.push(newState);
        this._countryService.addState(this._newState, this._code)
        .subscribe((result:boolean)=> this._newState="");
    }
      
}