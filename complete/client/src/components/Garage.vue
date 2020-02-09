<!--tag::template[]-->
<template>
  <div id="garage">
    <app-header></app-header>

    <vehicle-table :drivers="drivers" @save="saveVehicle($event)"></vehicle-table>
    <!--2-->
  </div>
</template>
<!--end::template[]-->
<!--tag::component[]-->
<script>
import AppHeader from "./AppHeader"; // <1>
import VehicleTable from "./table/VehicleTable";

export default {
  components: {
    // <1>
    AppHeader,
    VehicleTable
  },
  data: function() {
    // <2>
    return {
      bids: [],
      licences: [],
      drivers: [],
      serverURL: process.env.SERVER_URL
    };
  },
  // end::component[]
  // tag::fetch[]
  created() {
    // <1>
    this.fetchData();
  },
  methods: {
    fetchData: async function() {
      // <2>
      try {
        Promise.all([
          // <3>
          this.fetchModels(),
          this.fetchMakes(),
          this.fetchDrivers()
        ]);
      } catch (error) {
        console.log(error);
      }
    },
    // end::fetch[]
    // tag::methods[]

    fetchModels: function() {
      fetch(`${this.serverURL}/bid`)
        .then(r => r.json())
        .then(json => {
          this.bids = json;
        })
        .catch(error => console.error("Error retrieving models: " + error));
    },
    fetchMakes: function() {
      fetch(`${this.serverURL}/licence`)
        .then(r => r.json())
        .then(json => {
          this.licences = json;
        })
        .catch(error => console.error("Error retrieving makes: " + error));
    },
    fetchDrivers: function() {
      fetch(`${this.serverURL}/driver`)
        .then(r => r.json())
        .then(json => {
          this.drivers = json;
        })
        .catch(error => console.error("Error retrieving drivers: " + error));
    },
    saveVehicle: function([name, lclass, lno, bdate, bamount, id, lid, bid]) {
      fetch(`${this.serverURL}/licence/${lid}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: lid,
          licence_class: lclass,
          licence_no: lno
        })
      })
        .then(r => r.json())
        .then(json => {
          this.licences.push(json);
        })
        .catch(ex => console.error("Unable to save vehicle", ex));

      fetch(`${this.serverURL}/bid/${bid}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: bid,
          date: bdate,
          amount: bamount
        })
      })
        .then(r => r.json())
        .then(json => {
          this.bids.push(json);
        })
        .catch(ex => console.error("Unable to save vehicle", ex));

      fetch(`${this.serverURL}/driver/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: id,
          name: name
        })
      })
        .then(r => r.json())
        .then(json => {
          this.drivers.push(json);
        })
        .catch(ex => console.error("Unable to save vehicle", ex));
      location.reload();
    }
  }
};
</script>
<!--end::submit[]-->

<!--tag::css[]-->
<!-- Per Component Custom CSS Rules -->
<!--1-->
<style>
#garage {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
}
</style>
<!--end::css[]-->
