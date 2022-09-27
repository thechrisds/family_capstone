<template>
  <div>
      <ul>
          <li v-for="user in users" v-bind:key="user.id">
                {{user.username}}, 
                Family usernames
          </li>
      </ul>
  </div>
</template>

<script>
import accountService from '@/services/AccountService.js';
export default {
    name: 'account-list',
    props: ['users'],
    data() {
        return {
            users: [],
            id: ''
        };
    },
    methods: {

    },
    created() {
     
          accountService.getFamilyId().then(response => {
            this.id = response.data;
          });
        
            //call another method to get the id from the user
          
            accountService.getAllFamily(this.id).then(response => {
                if(response.status === 200) {
                    this.users = response.data;
                }
                
            })
            .catch(error => {
                if(error.response) {
                    this.errorMsg = 
                    "Error getting all Family Members."
                }
            });
        }
    

}
</script>

<style>

</style>