<html>
<body>
<p>Downloads:</p>
<form action='' method='post'>
  <button name='submit' value='0'>img</button>
  <button name='submit' value='1'>txt</button>  
  </form>
</div>

<script>
var ajaxObject;

if(window.XMLHttpRequest)
{
  // code for IE7+, Firefox, Chrome, Opera, Safari
  ajaxObject = new XMLHttpRequest();
}
else 
{ // code for IE6, IE5
  ajaxObject = new activeXObject("MICROSOFT.XMLHTTP");
}

function send_data(value)
{
ajaxObject.open("GET","" ?submit=" . value . ,true);
ajaxObject.send();
}

</script>

<?php

$txt = "";
$inp = "";

if(isset($_POST['submit']) ){
$inp = $_POST['submit'];

if ( $inp == 0){
$dir = "../img";
$txt = "Images";
} else if ( $inp == 1) {
	$dir = "../uploads";
	$txt = "Textfiles";
} else {
	$dir = "";
	$txt = "";
}

$allFiles = scandir($dir);
$files = array_diff($allFiles, array('.', '..')); // To remove . and .. 

echo ( $txt . ':<br>');
foreach($files as $file){
     echo "<a href='file_download.php?file=".$file."'>".$file."</a><br>";
 }
}
else {
	echo("");
}
?>
  <a href="../index.html" class="home">Home</a>
</body>
</html>
