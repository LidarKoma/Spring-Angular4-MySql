# Angularphp


export class AppComponent {
  title = 'Fun With countries';
  private _countries = COUNTRIES;

}
const COUNTRIES: ICountry[] =[{name: "United States", code: "us", states: [
 { name: "Nevada"},{name: "Colorado"}]},
 {name: "China", code: "cn", states: [
  { name: "Shaanxi"},{name: "Shanghai"}]},

  {name: "Germany", code: "de", states: [
    { name: "Bavaria"},{name: "Saxonia"}]},
    {name: "luxembourg", code: "lu", states: []}

 ];


 <div *ngIf="_countries && _countries.length">
  <h2>Countries</h2>
  <ul>

    <li *ngFor="let country of _countries">
        <img src="assets/images/{{ country.code }}.png">
        {{ country.name }}
        <span [hidden]="country.states.length==0">({{ country.states.length }} States)</span>
    </li>
  </ul>
 
   

 </div>
 -----------------------------------------
 <div *ngIf="_countries && _countries.length">
  <h2>Countries</h2>
  <ul>

    <li *ngFor="let country of _countries">
        <img src="assets/images/{{ country.code }}.png">
        {{ country.name }}
        <span [hidden]="country.states.length==0">({{ country.states.length }} States)</span>
    
  
  <ul>
    <li *ngFor="let state of country.states">
        {{ state.name }}
    </li>
 
  </ul>
   </li>
</ul>
 </div>
 -------------------------
   export class AppComponent {
  title = 'Fun With countries';
  private _countries = COUNTRIES;
  private _detailsVisible: boolean = false;

 toggleDetails(): void {
  this._detailsVisible=!this._detailsVisible;
}
}
----------------
now we need another component so we can split better when click the 
----------------------
INSERT INTO `states`(`name`, `code`, `country_id`) VALUES ('NorthD',"us",(SELECT id FROM country WHERE code='us'))
