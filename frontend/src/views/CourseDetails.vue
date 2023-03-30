<template>
  <div class="ma-16 pa-10 black lighten-2">
    <p>Kurs Kayıt Paneli</p>
    <v-form v-model="valid">
      <v-text-field v-model="id" v-if="updatable || deletable" label="Kurs No" :rules="idRules"></v-text-field>
      <v-text-field v-model="name" label="Name" :rules="nameRules" v-if="!deletable" :counter="15" required>

      </v-text-field>

      <v-text-field v-model="price" label="Price" :rules="priceRules" v-if="!deletable" required>

      </v-text-field>


      <v-btn @click="saveCourse" class="green mr-4 mt-2">
        Kaydet
      </v-btn>
      <v-btn @click="updateCourse" class="warning mr-4 mt-2">
        Güncelle
      </v-btn>

      <v-btn @click="deleteCourse" class="mr-4 mt-2" color="#FF0000">
        Sil
      </v-btn>
      <v-btn @click="clearCourse" class=" mr-4 mt-2" color="#a7d5ed">
        Temizle
      </v-btn>

    </v-form>





  </div>
</template>

<script lang="ts">

export default {
  data() {
    return {
      updatable: false,
      deletable: false,
      valid: false,
      name: "",
      price: null,
      id: 0,
      nameRules: [
        v => !!v || 'Name is required',
        v => v.length <= 15 || 'Name must be less than 15 characters',
        v => !(v < 0 || v >= 0) || 'Name must be string',
      ],
      priceRules: [
        v => !!v || 'Price is required',
        v => v >= 0 || 'Please give a valid price',
      ],
      idRules: [
        v => !!v || 'İd is required'
      ]

    }
  },


  methods: ({
    clearCourse() {
      this.name = ''
      this.price = null

    },
    saveCourse() {

      if (this.valid) {
        console.log("savelenebilir")
        this.$http.post('http://localhost:8080/api/addcourse', {
          name: this.name,
          price: this.price
        }).then(function (data) {
          console.log(data);
        })
      } else {
        console.log("hatalı save")
      }

    },
    updateCourse() {

      if (this.valid) {
        console.log("updatelenebilir")
        this.$http.post('http://localhost:8080/api/updatecourse', {
          id: this.id,
          name: this.name,
          price: this.price
        }).then(function (data) {
          console.log(data);
        })
      } else {
        console.log("hatalı update")
      }
      this.updatable = !this.updatable
      this.clearCourse(); 
    },
    deleteCourse() {

      this.$http.delete('http://localhost:8080/api/deletecourse?id=' + this.id).then(function (data) {
        console.log(data);
      })

      this.deletable = !this.deletable
      this.clearCourse();
    },


  })

}
</script>

<style>
</style>