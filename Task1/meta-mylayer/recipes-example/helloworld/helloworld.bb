SUMMARY = "This is a simple recipe to build a c program using cmake"
MAINTAINER = "Rahma Abdelkader"
LICENSE = "CLOSED"
FILESEXTRAPATHS:prepend := "${THISDIR}/ITI-45:"
SRC_URI = "file://CMakeLists.txt \
	   file://main.c \
"

PN = "helloworld"
PV = "1.0"
PR = "r0"

S = "${WORKDIR}"
B = "${WORKDIR}/build"
	
inherit cmake	

do_configure(){
	cmake -S ${S} -B ${B} 
}

do_compile(){
	cmake --build ${B}
}

do_install(){
	install -d ${D}/${bindir}
	install -m 0777 ${B}/${PN} ${D}/${bindir}/${PN}
}

COMPATIBLE_MACHINE = "raspberrypi3-64"