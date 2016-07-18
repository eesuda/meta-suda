LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Allows to avoid fetching, unpacking and patching, since our code is already cloned by repo
inherit externalsrc

SRCREV = "edison-3.10.98"

# Don't use Yocto kernel configuration system, we instead simply override do_configure
do_configure() {
  cp "${TOPDIR}/../../edison-linux/arch/x86/configs/i386_edison_defconfig" "${TOPDIR}/../../edison-linux/.config"
}

do_compile() {
}

do_compile_kernelmodules() {
}

EXTERNALSRC_pn-linux-externalsrc = "${TOPDIR}/../../edison-linux"
EXTERNALSRC_BUILD_pn-linux-externalsrc = "${TOPDIR}/../../edison-linux"

LINUX_VERSION ?= "3.10"
LINUX_VERSION_EXTENSION = "-edison-${LINUX_KERNEL_TYPE}"

PR = "r2"

COMPATIBLE_MACHINE = "edison"

do_kernel_configme() {
  echo "skip this option"
}
