<template>
    <div>
    <view-activity />
    <div class="activity">
    <router-link to="/activity"> Log An Activity </router-link>
    </div>
    </div>
</template>

<script>
import Activity from '@/components/Activity'

export default ({
    components: {
        Activity
    }
});
</script>

<style>
.activity{
    text-align:left;
}
</style>