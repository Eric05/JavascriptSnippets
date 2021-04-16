<?php
$email_from = "absender@domain.de";   //Absender falls keiner angegeben wurde
$sendermail_antwort = true;      //E-Mail Adresse des Besuchers als Absender. false= Nein ; true = Ja
$name_von_emailfeld = "Email";   //Feld in der die Absenderadresse steht
 
$empfaenger = "empfaenger@domain.de"; //Empfänger-Adresse
$mail_cc = ""; //CC-Adresse, diese E-Mail-Adresse bekommt einer weitere Kopie
$betreff = "Neue Kontaktanfrage"; //Betreff der Email
 
$url_ok = "http://www.domain.de/ok.php"; //Zielseite, wenn E-Mail erfolgreich versendet wurde
$url_fehler = "http://www.domain.de/fehler.php"; //Zielseite, wenn E-Mail nicht gesendet werden konnte
 
//send_email.php

$to = "mail@mail.com";
$cc = "CC: somebodyelse@example.com";
$subject = "Donation";
$name=  ($_POST["name"]);
$from = ($_POST["from"]);
$text = ($_POST["text"]);
$headers = $from . "\r\n" . $cc;

# mail($to,$subject,$text,$headers);

echo( $subject . "<br>" . $name . " sends" . $to . " Msg: " .$text . "<br>" .  $headers);

?>