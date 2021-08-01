#include <InetConstants.au3>
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>


Example()

Func Example()


    ; Save the downloaded file to the temporary folder.

    Local $sFilePath = _WinAPI_GetTempFileName("C:\Test\MegaAutomation\MegaTestAutomationi\testData")
	 Local $arr[3] ; Make room for three elements
 ;Assign some data
 $arr[0] = "C:\Test\MegaAutomation\MegaTestAutomationi\testData\File1"
 $arr[1] = "C:\Test\MegaAutomation\MegaTestAutomationi\testData\File2"
 $arr[2] = "C:\Test\MegaAutomation\MegaTestAutomationi\testData\File3"

    ; Download the file by waiting for it to complete. The option of 'get the file from the local cache' has been selected.

    Local $iBytesSize = InetGet("https://mega.nz/linux/MEGAsync/Arch_Extra/x86_64/megasync-x86_64.pkg.tar.zst",  $arr[0], $INET_FORCERELOAD)
	  Local $iBytesSize = InetGet("https://mega.nz/linux/MEGAsync/CentOS_8/x86_64/megasync-CentOS_8.x86_64.rpm",  $arr[1], $INET_FORCERELOAD)
	    Local $iBytesSize = InetGet("https://mega.nz/linux/MEGAsync/CentOS_7/x86_64/megasync-CentOS_7.x86_64.rpm",  $arr[2], $INET_FORCERELOAD)


For $i = 0 To 2 Step 1
     Local $BytesSize = InetGet($arr[$i], $sFilePath, $INET_FORCERELOAD)
Next

EndFunc


