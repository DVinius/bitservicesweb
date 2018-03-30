$(document).ready(function(){
  $('.button-collapse').sideNav();
  $('select').material_select();
  $('.modal').modal();
});

function copytoclipboard() {
  var copyText = document.getElementById("walletAddress");
  copyText.select();
  document.execCommand("Copy");
  Materialize.toast('Endereço copiado para área de transferência (Ctrl+C)', 3000, 'rounded') // 'rounded' is the class I'm applying to the toast
}