<template>
  <v-card class="pa-10 mt-15 mx-5 mb-5 blue lighten-4 absolute">
    <v-row style="height: auto; width: auto" align="center">
      <v-col cols="12" sm="12" md="12" lg="6">
        <v-card class="pa-2 white" outlined>
          <v-list-item class="black">
            <v-list-item-content>
              <div class="text-overline ma-4">Öğrenci Ekranı</div>
              <div class="text-overline ma-4">
                <h1>Öğrenci Ekleme, Silme ve Güncelleme İşlemlerİ</h1>
              </div>
            </v-list-item-content>

            <div class="d-none d-md-block">
              <v-list-item-avatar tile size="200" color="grey" class="ml-10"
                ><img
                  src="http://cdn.icon-icons.com/icons2/1465/PNG/512/132womanstudent2_100407.png"
                  alt="Öğrenci"
                />
              </v-list-item-avatar>
            </div>
          </v-list-item>
          <v-card-actions>
            <v-btn
              outlined
              rounded
              text
              class="ma-4"
              style="background-color: darkcyan"
              router
              :to="'/studentPage'"
            >
              Tıkla
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="12" sm="12" md="12" lg="6">
        <v-card class="pa-2 white" outlined>
          <v-list-item class="black lighten-1">
            <v-list-item-content>
              <div class="text-overline ma-4">Kurs Ekranı</div>
              <div class="text-overline ma-4">
                <h1>Kurs Ekleme, Silme ve Güncelleme İşlemlerİ</h1>
              </div>
            </v-list-item-content>
            <div class="d-none d-md-block">
              <v-list-item-avatar tile size="200" color="grey" class="ml-10">
                <img
                  src="http://cdn.icon-icons.com/icons2/1408/PNG/256/books_97178.png"
                  alt="Kurs"
                />
              </v-list-item-avatar>
            </div>
          </v-list-item>
          <v-card-actions>
            <v-btn
              outlined
              rounded
              text
              class="ma-4"
              style="background-color: darkcyan"
              router
              :to="'/coursePage'"
            >
              Tıkla
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-card>
</template>

<script lang="ts">
export default {};
</script>

<style></style>
