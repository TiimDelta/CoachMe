export class App {
  constructor() {
    this.message = 'Hello World!';
  }
  configureRouter(config, router) {
    this.router = router;
    config.title = 'My Aurelia app';
    config.map([
      { route: ['', 'home'],       name: 'home',       moduleId: 'home/index' },
      { route: 'coach',       name: 'coach',       moduleId: 'resources/coach', nav:true }
    ]);
  }
}
