<template>
  <div>
    <account-list />
    <add-user />
  </div>
</template>

<script>
import AccountList from "@/components/AccountList";
import AddUser from "@/components/AddUser";

export default {
  components: {
    AccountList,
    AddUser,
  },
};
</script>

<style>
</style>