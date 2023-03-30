<template>
  <div class="ma-16 pa-10 black lighten-2">
    <p>Öğrenci Kayıt Paneli</p>

    <v-form v-model="valid">
      <v-text-field v-model="id" v-if="updatable || deletable" label="Öğrenci Numarası" :rules="idRules">

      </v-text-field>
      <v-text-field v-model="name" v-if="!deletable" label="Ad" :rules="nameRules" :counter="10" required>

      </v-text-field>

      <v-text-field v-model="grade" label="Puan" v-if="!deletable" :rules="gradeRules" required>

      </v-text-field>

      <v-select v-model="gender" :items="genders" v-if="!deletable" label="Cinsiyet" :rules="genderRules" required></v-select>

      <v-select v-model="coursesNamesSelected" v-if="!deletable" :items="coursesNames" label="Kurslar" multiple></v-select>


      <v-btn @click="saveStudent" class="green mr-4 mt-2">
        Kaydet
      </v-btn>
      <v-btn @click="updateStudent" class="warning mr-4 mt-2">
        Güncelle
      </v-btn>

      <v-btn @click="deleteStudent" class="mr-4 mt-2" color="#FF0000">
        Sil
      </v-btn>
      <v-btn @click="clearStudent" class=" mr-4 mt-2" color="#a7d5ed">
        Temizle
      </v-btn>
    </v-form>
  </div>
</template>


<script lang="ts">
enum Gender {
  E,
  K
}

import Course from "@/types/Course"
export default {

  data() {
    let courses: Course[] = []
    let selectedCourses: Course[] = []
    let courseTemp: Course
    let coursesNames: string[] = [];
    let coursesNamesSelected: string[] = [];
  
    return {
      updatable: false,
      deletable: false,
      valid: false,
      name: "",
      id: 0,
      grade: null,
      genders: [
        Gender[0],
        Gender[1]
      ],
      courses,
      selectedCourses,
      courseTemp,
      coursesNames,
      coursesNamesSelected,
      gender: "",
      nameRules: [
        v => !!v || 'Name is required',
        v => v.length <= 10 || 'Name must be less than 10 characters',
        v => !(v < 0 || v >= 0) || 'Name must be string',
      ],
      gradeRules: [
        v => !!v || 'Grade is required',
        v => (v <= 100 && v >= 0) || 'Grade must be between 0 and 100',
      ],
      genderRules: [
        v => !!v || 'Gender must be choosen'
      ],
      idRules: [
        v => !!v || 'Id is required'
      ]
    }


  },
  async mounted() {
    const names: string[] = [];
    fetch('http://localhost:8080/api/courses')
      .then((res) => res.json())
      .then((data) => this.courses = data)
      .then(function (data) {
        for (let i = 0; i < data.length; i++) {
          names.push(data[i]["name"]);
        }
      })
    this.coursesNames = names;

  },

  methods: ({
    clearStudent() {
      this.id = 0
      this.name = ''
      this.grade = null
      this.gender = ''
      this.selectedCourses = []
      this.coursesNamesSelected =  []
    },
    saveStudent() {
      if (this.valid) {
        console.log("valid")
        for (let i = 0; i < this.courses.length; i++) {
          for (let j = 0; j < this.coursesNamesSelected.length; j++) {
            if (this.courses[i]["name"] == this.coursesNamesSelected[j]) {
              this.selectedCourses.push(this.courses[i]);
            }
          }

        }
        //8 dödürdü
        console.log("selected course  : " + this.selectedCourses.length)

        this.$http.post('http://localhost:8080/api/addstudent', {
          name: this.name,
          grade: this.grade,
          gender: this.gender,
          courses: this.selectedCourses,
        })
        this.clearStudent()

      } else {
        console.log("hatalı save")
        console.log("selected course  : " + this.selectedCourses.length)
      }

    },
    updateStudent() {
      

      for (let i = 0; i < this.courses.length; i++) {
        for (let j = 0; j < this.coursesNamesSelected.length; j++) {
          if (this.courses[i]["name"] == this.coursesNamesSelected[j]) {
            this.selectedCourses.push(this.courses[i]);
          }
        }

      }

      if (this.valid) {
        this.$http.post('http://localhost:8080/api/updatestudent', {
          id: this.id,
          name: this.name,
          grade: this.grade,
          gender: this.gender,
          courses: this.selectedCourses,
        })
        console.log("valid")
      } else {
        console.log("else")
      }
      this.updatable = !this.updatable




    },
    deleteStudent() {   
        this.$http.delete('http://localhost:8080/api/deletestudent?id='+this.id )   
        this.deletable = !this.deletable

        this.clearStudent();
    }


  })


}
</script>

<style>
</style>