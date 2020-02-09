<template id="tablerow-template" xmlns="http://www.w3.org/1999/xhtml">
  <tr>
    <!-- 1 -->
    <td>{{ item.name }}</td>
    <td>{{ item.licence.licenceclass }}</td>
    <td>{{ item.licence.licenceno }}</td>
    <td>{{ item.bid.biddate }}</td>
    <td>{{ item.bid.bidamount }}</td>
    <td>
      <button
        type="button"
        @click="edit([item.name,item.licence.licenceclass, item.licence.licenceno,
	  item.bid.biddate,item.bid.bidamount,item.id,item.licence.id,item.bid.id])"
      >Edit</button>
    </td>
  </tr>
</template>

<script>
export default {
  props: ["item"], // <1>
  methods: {
    edit(name, lclass, lno, bdate, bamount, id, lid, bid) {
      this.$emit("edit", name, lclass, lno, bdate, bamount, id, lid, bid);
    }
  }
};
</script>

<!-- Per Component Custom CSS Rules -->
<style>
/* Add custom rules here */
</style>
