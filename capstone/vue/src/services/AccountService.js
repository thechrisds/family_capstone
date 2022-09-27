import axios from 'axios';

export default {
    getAllFamily(familyId) {
        return axios.get(`/account/${familyId}`)
    },
    
    getFamilyId() {
        return axios.get(`/account/username`)
    }
}