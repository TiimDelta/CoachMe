import {inject} from 'aurelia-framework';
import {FetchConfig} from 'aurelia-auth';

@inject(FetchConfig)
export class App {

  constructor(fetchConfig) {
    this.fetchConfig = fetchConfig;
  }

  configureRouter(config, router) {
    this.router = router;
    this.fetchConfig.configure();
    config.title = 'My Aurelia app';
    config.map([
      { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
      { route: 'coach',       name: 'coach',       moduleId: 'resources/coach', nav:true }
    ]);
  }
}
