function copytoclipboard() {
  var copyText = document.getElementById("walletAddress");
  copyText.select();
  document.execCommand("Copy");
  Materialize.toast('Endereço copiado para área de transferência (Ctrl+C)', 3000, 'rounded') // 'rounded' is the class I'm applying to the toast
}

function openLink(linkURL){
  window.location = linkURL;
}

function onPayBeer(){
  openLink('/paybeer');
}

//javascript: alert(document.getElementsByTagName('main')[0].innerHTML);
//window.scrollTo(0,1);