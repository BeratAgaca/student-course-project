<template>
  <v-app style="background-color: #f00000">
    <SideBar />

    <router-view />
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import SideBar from "./components/SideBar.vue";
export default Vue.extend({
  name: "App",
  data: () => ({
    //
  }),
  components: { SideBar },
});
</script>
