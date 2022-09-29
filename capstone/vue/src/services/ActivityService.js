import axios from 'axios';

export default {

    seeActivity(){
      return axios.get('/activity');
    },
    
    addActivity(activity){
        return axios.post('/activity/', activity);
    }
  }
