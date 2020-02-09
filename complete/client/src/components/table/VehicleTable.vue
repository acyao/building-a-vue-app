<template id="fulltable-template" xmlns="http://www.w3.org/1999/xhtml">
  <div>
    <div id="editvehicle" class="row">
      <div class="col-sm-2">
        <input type="text" placeholder="Edit ID" v-model="itemname" />
      </div>
      <div class="col-sm-2">
        <input type="text" placeholder="Edit licence class" v-model="itemlclass" />
      </div>
      <div class="col-sm-2">
        <input type="text" placeholder="Edit licence no" v-model="itemlno" />
      </div>
      <div class="col-sm-2">
        <input type="text" placeholder="Edit bid date" v-model="itembdate" />
      </div>
      <div class="col-sm-2">
        <input type="text" placeholder="Edit amount" v-model="itembamount" />
      </div>
      <div class="col-sm-2">
        <button
          type="button"
          @click="save([itemname,itemlclass,itemlno,itembdate,itembamount,itemid,itemlid,itembid])"
        >Save</button>
      </div>
    </div>
    <table class="table">
      <thead class="thead-inverse">
        <tr>
          <th>Name</th>
          <th>Class</th>
          <th>Licence_no</th>
          <th>Bid_Date</th>
          <th>Amount</th>
          <th>Action</th>
        </tr>
      </thead>
      <!--1-->
      <table-row v-for="driver in drivers" :item="driver" :key="driver.id" @edit="editBtn($event)"></table-row>
      <!--2-->
    </table>
  </div>
</template>

<script>
import TableRow from "./TableRow.vue"; // <3>

export default {
  props: ["drivers"],
  components: {
    // <3>
    TableRow
  },
  data: function() {
    return {
      itemid: "",
      itemname: "",
      itemlclass: "",
      itemlno: "",
      itembdate: "",
      itembamount: "",
      itemlid: "",
      itembid: ""
    };
  },
  methods: {
    editBtn: function([name, lclass, lno, bdate, bamount, id, lid, bid]) {
      this.itemname = name;
      this.itemlclass = lclass;
      this.itemlno = lno;
      this.itembdate = bdate;
      this.itembamount = bamount;
      this.itemid = id;
      this.itemlid = lid;
      this.itembid = bid;
    },
    save(name, lclass, lno, bdate, bamount, id, lid, bid) {
      this.$emit("save", name, lclass, lno, bdate, bamount, id, lid, bid);
    }
  }
};
</script>

<style>
/* Add custom rules here */
</style>
