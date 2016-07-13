PACKAGES =+ " \
             ${PN}-bcm43362 \
             "

# For broadcom
#
# WARNING: The ALTERNATIVE_* variables are not using ${PN} because of
# a bug in bitbake; when this is fixed and bitbake learns how to proper
# pass variable flags with expansion we can rework this patch.

LICENSE_${PN}-bcm43362 = "Firmware-broadcom_bcm43xx"

FILES_${PN}-bcm43362 = " \
  /lib/firmware/brcm/brcmfmac43362-sdio.bin \
"
ALTERNATIVE_linux-firmware-bcm43362 = "brcmfmac-sdio.bin"
ALTERNATIVE_TARGET_linux-firmware-bcm43362[brcmfmac-sdio.bin] = "/lib/firmware/brcm/brcmfmac43362-sdio.bin"

RDEPENDS_${PN}-bcm43362 += "${PN}-broadcom-license"
