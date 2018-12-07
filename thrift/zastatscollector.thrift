namespace java com.vng.zing.statcollect.thrift

struct TPeakInfo {
	1:required i32 value,
	2:required i64 timestamp	
}

struct TSecStatPoint {
	1:required i32 totalReq,
	2:required i64 totalTimeProc,
	3:required i64 timestamp,
	4:required TPeakInfo peakTimeProc,
	5:required TPeakInfo peakPendingReq	
}

struct TMinStatPoint {
	1:required i32 totalReq,
	2:required i64 totalTimeProc,
	3:required i64 timestamp,
	4:required TPeakInfo peakTimeProc,
	5:required TPeakInfo peakPendingReq,
	6:required TPeakInfo peakReqRateSecond	
}

struct TMapStatPoint {
	1:optional map<string, TSecStatPoint> secondMap,
	2:optional map<string, TMinStatPoint> minuteMap,
}

service ZACollectStatsService {
	i32 pushMapStatPoint(1:required TMapStatPoint mapStatPoint);
}

