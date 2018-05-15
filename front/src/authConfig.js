var configForDevelopment = {
  profileUrl: 'http://localhost:8080/auth/me',
  providers: {
    google: {
      clientId: '250693155108-9an7osadhjlj2f3s1m4ib1k8dgg93njs.apps.googleusercontent.com',
      url: 'http://localhost:8080/auth/google'
    }
    ,
    linkedin:{
      clientId:'778mif8zyqbei7'
    },
    facebook:{
      clientId:'1452782111708498'
    }
  }
};

var configForProduction = {
  profileUrl: 'http://localhost:8080/auth/me',
  providers: {
    google: {
      clientId: '250693155108-9an7osadhjlj2f3s1m4ib1k8dgg93njs.apps.googleusercontent.com',
      url: 'http://localhost:8080/auth/google'
    }
    ,
    linkedin:{
      clientId:'7561959vdub4x1'
    },
    facebook:{
      clientId:'1653908914832509'
    }

  }
};
var config ;
if (window.location.hostname==='localhost') {
  config = configForDevelopment;
}
else{
  config = configForProduction;
}


export default config;
