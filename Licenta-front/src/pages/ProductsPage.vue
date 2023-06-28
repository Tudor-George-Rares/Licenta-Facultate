<template>
  <q-page-container>
    <q-page padding>
      <q-card>
        <q-card-section class="row items-center justify-center">
          <q-avatar
            size="72px"
            class="q-ma-sm"
            style="background-color: #027be3; color: white"
          >
            <q-icon name="school" />
          </q-avatar>
          <q-card-section>
            <q-card-title class="text-h6">Produse</q-card-title>
            <q-card-title class="text-subtitle2">
              Cele mai calitative produse
            </q-card-title>
          </q-card-section>
        </q-card-section>

        <q-separator />

        <q-card-section class="row items-center justify-center">
          <q-list bordered separator>
            <q-item
              v-for="link in linksList"
              :key="link.title"
              clickable
              v-ripple
            >
              <q-item-section avatar>
                <q-icon :name="link.icon" />
              </q-item-section>

              <q-item-section>
                <q-item-label>{{ link.title }}</q-item-label>
                <q-item-label caption lines="2">
                  {{ link.caption }}
                </q-item-label>
              </q-item-section>

              <q-item-section side>
                <essential-link :to="link.link" />
              </q-item-section>
            </q-item>
          </q-list>
        </q-card-section>
      </q-card>
    </q-page>
  </q-page-container>
</template>

<script>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'ProductsPage',
  setup() {
    return {};
  },
});
</script>

<style></style>
