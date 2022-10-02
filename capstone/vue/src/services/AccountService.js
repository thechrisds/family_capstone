import axios from 'axios';

export default {
    getAllFamily(familyId) {
        return axios.get(`/account/${familyId}`);
    },
    
    getFamilyId(username) {
        return axios.get(`/account/username/${username}`);
    },

    addUser(user) {
        return axios.post('/account/newChild', user);
    },

    deleteUser(id) {
        return axios.delete(`/account/${id}`)
    }

}