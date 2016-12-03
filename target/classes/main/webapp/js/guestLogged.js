var $rTable = $("#2");
var $aTable = $('#1');

function toggleTable()
{
   if (document.getElementById("1").style.display == "table" ) {
       document.getElementById("1").style.display="none";
       
   } else {
      document.getElementById("1").style.display="table";
	  document.getElementById("2").style.display="none";
	  

}
}

function toggleTable2()
{
   if (document.getElementById("2").style.display == "table" ) {
       document.getElementById("2").style.display="none";
       $rTable.removeClass("tbl-content2");
   } else {
       document.getElementById("1").style.display="none";
	  document.getElementById("2").style.display="table";
	  $rTable.removeClass("tbl-content2");
}
}