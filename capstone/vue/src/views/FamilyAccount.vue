<template>
  <div id="family-account">
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
#family-account{
  min-width:0;
}
</style>