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
    //props: ['users'],
    data() {
        return {
            users: [],
            id: '',
            username: this.$store.state.user.username
        
        };
    },
    methods: {

    },
    created() {
            console.log(this.username);
          accountService.getFamilyId(this.username).then(response => {
            console.log(response);
            this.id = response.data;
            
            accountService.getAllFamily(this.id).then(response => {
                console.log('getAllFamilyResponse: ', response);
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
        
          });
        
          
            
        }
    

}
</script>

<style>

</style>