import axios from 'axios';

export default {

    seeUserActivity(){
      return axios.get('/activity/user');
    },
    
    addActivity(activity){
        return axios.post('/activity/', activity);
    },

    seeFamilyActivity(){
      return axios.get('/activity/family');
    }
  }
